import React, { useState, useEffect } from 'react';
import { saveVenta, getAllVentas, deleteVenta } from '../services/ventaService';
import { getAllClientes } from '../services/clienteService';
//import { getAllProductos } from '../services/productoService';
import { useNavigate } from 'react-router-dom';
import HomeButton from './HomeButton';

const VentaForm = () => {
  const [clienteId, setClienteId] = useState('');
  const [productoId, setProductoId] = useState('');
  const [clientes, setClientes] = useState([]);
  const [productos, setProductos] = useState([]);
  const [ventas, setVentas] = useState([]);
  const [fecha, setFecha] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    fetchClientes();
    fetchProductos();
    fetchVentas();
  }, []);

  const fetchClientes = async () => {
    const data = await getAllClientes();
    setClientes(data);
  };

  const fetchProductos = async () => {
    const data = await getAllProductos();
    setProductos(data);
  };

  const fetchVentas = async () => {
    const data = await getAllVentas();
    setVentas(data);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const newVenta = { clienteId, productoId, fecha };
    await saveVenta(newVenta);
    fetchVentas();
    setClienteId('');
    setProductoId('');
    setFecha('');
  };

  const handleDelete = async (id) => {
    if (window.confirm('¿Estás seguro de eliminar esta venta?')) {
      await deleteVenta(id);
      fetchVentas();
    }
  };

  const getClienteName = (id) => {
    const cliente = clientes.find(c => c.id === id);
    return cliente ? cliente.nombre : '';
  };

  const getProductoName = (id) => {
    const producto = productos.find(p => p.id === id);
    return producto ? producto.nombreEvento : '';
  };

  return (
    <div>
      <h2>Nueva venta</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="cliente">Cliente:</label>
          <select
            id="cliente"
            value={clienteId}
            onChange={(e) => setClienteId(e.target.value)}
          >
            <option value="">Seleccione un cliente</option>
            {clientes.map(cliente => (
              <option key={cliente.id} value={cliente.id}>
                {cliente.nombre}
              </option>
            ))}
          </select>
        </div>
        <p></p>
        <div>
          <label htmlFor="producto">Producto:</label>
          <select
            id="producto"
            value={productoId}
            onChange={(e) => setProductoId(e.target.value)}
          >
            <option value="">Seleccione un producto</option>
            {productos.map(producto => (
              <option key={producto.id} value={producto.id}>
                {producto.nombreEvento}
              </option>
            ))}
          </select>
        </div>
        <p></p> 
        <button type="submit" className="btn btn-primary">Guardar</button>
      </form>

      <div className="mt-4">
        <h2>Listado de Ventas</h2>
        <table className="table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Cliente</th>
              <th>Evento</th>
              <th>Fecha de Transacción</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {ventas.map(venta => (
              <tr key={venta.id}>
                <td>{venta.id}</td>
                <td>{getClienteName(venta.clienteId)}</td>
                <td>{getProductoName(venta.productoId)}</td>
                <td>{new Date(venta.fecha).toISOString().slice(0, 10)}</td>
                <td>
                  <button className="btn btn-sm btn-danger ml-2" onClick={() => handleDelete(venta.id)}>Eliminar</button>
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
