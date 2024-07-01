import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import HomeButton from './HomeButton';
import useClientes from '../services/clienteService';
import useProductos from '../services/productoService';
import useVentas from '../services/ventaService';

const VentaForm = () => {
  const [clienteId, setClienteId] = useState('');
  const [productoId, setProductoId] = useState('');
  const [clientes, setClientes] = useState([]);
  const [productos, setProductos] = useState([]);
  const { ventas, saveVenta, deleteVenta } = useVentas();
  const [fecha, setFecha] = useState('');
  const navigate = useNavigate();

  const { getAllClientes, clientes: allClientes } = useClientes();
  const { getAllProductos, productos: allProductos } = useProductos();

  useEffect(() => {
    fetchClientes();
    fetchProductos();
  }, []);

  useEffect(() => {
    setClientes(allClientes);
  }, [allClientes]);

  useEffect(() => {
    setProductos(allProductos);
  }, [allProductos]);

  const fetchClientes = async () => {
    await getAllClientes();
  };

  const fetchProductos = async () => {
    await getAllProductos();
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const newVenta = { clienteId, productoId, fecha };
    try {
      await saveVenta(newVenta);
      setClienteId('');
      setProductoId('');
      setFecha('');
    } catch (error) {
      console.error('Error al guardar la venta:', error);
      navigate('/error');
    }
  };

  const handleDelete = async (id) => {
    if (window.confirm('¿Estás seguro de eliminar esta venta?')) {
      try {
        await deleteVenta(id);
      } catch (error) {
        console.error('Error al eliminar la venta:', error);
        navigate('/error');
      }
    }
  };

  const getClienteName = (id) => {
    const cliente = clientes.find((c) => c.id === id);
    return cliente ? cliente.nombre : '';
  };

  const getProductoName = (id) => {
    const producto = productos.find((p) => p.id === id);
    return producto ? producto.nombreEvento : '';
  };

  return (
    <div>
      <h2>Nueva venta</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="cliente" className="form-label">
            Cliente:
          </label>
          <select
            id="cliente"
            className="form-select"
            value={clienteId}
            onChange={(e) => setClienteId(e.target.value)}
          >
            <option value="">Seleccione un cliente</option>
            {clientes.map((cliente) => (
              <option key={cliente.id} value={cliente.id}>
                {cliente.nombre}
              </option>
            ))}
          </select>
        </div>
        <div className="mb-3">
          <label htmlFor="producto" className="form-label">
            Producto:
          </label>
          <select
            id="producto"
            className="form-select"
            value={productoId}
            onChange={(e) => setProductoId(e.target.value)}
          >
            <option value="">Seleccione un producto</option>
            {productos.map((producto) => (
              <option key={producto.id} value={producto.id}>
                {producto.nombreEvento}
              </option>
            ))}
          </select>
        </div>
        <button type="submit" className="btn btn-primary">
          Guardar
        </button>
      </form>

      <div className="mt-4">
        <h2>Listado de Ventas</h2>
        <table className="table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Cliente</th>
              <th>Producto</th>
              <th>Fecha de Transacción</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {ventas.map((venta) => (
              <tr key={venta.id}>
                <td>{venta.id}</td>
                <td>{getClienteName(venta.clienteId)}</td>
                <td>{getProductoName(venta.productoId)}</td>
                <td>{new Date(venta.fecha).toISOString().slice(0, 10)}</td>
                <td>
                  <button
                    className="btn btn-sm btn-danger ml-2"
                    onClick={() => handleDelete(venta.id)}
                  >
                    Eliminar
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      <div className="mt-4">
        <HomeButton />
      </div>
    </div>
  );
};

export default VentaForm;
