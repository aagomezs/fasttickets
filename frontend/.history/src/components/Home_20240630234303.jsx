import React, { useEffect } from 'react';
import { Link } from 'react-router-dom';
import '../Home.css';
import useClientes from '../services/clienteService';
import useProductos from '../services/productoService';
import useVentas from '../services/ventaService';

const Home = () => {
  const { productos, getAllProductos, deleteProducto } = useProductos();
  const { ventas, getAllVentas } = useVentas();
  const { clientes } = useClientes();

  useEffect(() => {
    const fetchData = async () => {
      await getAllProductos(); 
      await getAllVentas(); 
    };
    fetchData();
  }, [getAllProductos(), getAllVentas()]);

  const handleDelete = async (id) => {
    if (window.confirm('¿Estás seguro de eliminar este producto?')) {
      await deleteProducto(id);
      await getAllProductos(); 
    }
  };

  return (
    <div className="container">
      <h1 className="text-center">Bienvenido a FastTickets</h1>
      <p className="text-center">El mejor lugar para adquirir tus boletas</p>
      <div className="row">
        <div className="col-md-4">
          <h2>Eventos</h2>
          <Link to="/productos/add" className="btn btn-primary mt-3">
            Nuevo evento
          </Link>
          <ul className="list-group">
            {productos.map((producto) => (
              <li
                key={producto.id}
                className="list-group-item d-flex justify-content-between align-items-center"
              >
                <div>
                  {producto.nombreEvento}
                  <br />
                  <small>
                    {producto.lugarEvento} - ${producto.precio}
                  </small>
                </div>
                <button
                  onClick={() => handleDelete(producto.id)}
                  className="btn btn-sm btn-danger"
                >
                  Eliminar
                </button>
              </li>
            ))}
          </ul>
        </div>
        <div className="col-md-4">
          <h2>Clientes</h2>
          <Link to="/clientes/add" className="btn btn-success mt-3">
            Registrar cliente
          </Link>
          <ul className="list-group">
            {clientes.map((cliente) => (
              <li key={cliente.id} className="list-group-item">
                {cliente.nombre} - {cliente.email}
              </li>
            ))}
          </ul>
        </div>
        <div className="col-md-4">
          <h2>Ventas</h2>
          <Link to="/ventas/add" className="btn btn-success mt-3">
            Registrar Venta
          </Link>
          <ul className="list-group">
            {ventas.map((venta) => (
              <li key={venta.id} className="list-group-item">
                Venta ID: {venta.id}
              </li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default Home;
