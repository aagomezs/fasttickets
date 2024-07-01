import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import '../Home.css';
import { deleteProducto } from '../services/productoService';
import { getAllClientes } from '../services/clienteService';
import { getAllVentas } from '../services/ventaService';

const Home = () => {
  const [productos, setProductos] = useState([]);
  const [clientes, setClientes] = useState([]);
  const [ventas, setVentas] = useState([]);

  useEffect(() => {
    fetchProductos();
   // getAllProductos().then(data => setProductos(data));
    getAllClientes().then(data => setClientes(data));
    getAllVentas().then(data => setVentas(data));
  }, []);

  const fetchProductos = async () => {
    const data = await getAllProductos();
    setProductos(data);
  };

  const handleDelete = async (id) => {
    if (window.confirm('¿Estás seguro de eliminar este producto?')) {
      await deleteProducto(id);
      fetchProductos(); 
    }
  };

  return (
    <div className="container">
      <h1 className="text-center">Bienvenido a FastTickets</h1>
      <p className="text-center">El mejor lugar para adquirir tus boletas</p>
      <div className="row">
        <div className="col-md-4">
          <h2>Eventos</h2>
          <Link to="/productos/add" className="btn btn-primary mt-3">Nuevo evento</Link>
          <ul className="list-group">
            {productos.map(producto => (
              <li key={producto.id} className="list-group-item d-flex justify-content-between align-items-center">
                <div>
                  {producto.nombreEvento}
                  <br />
                  <small>{producto.lugarEvento} - {"$" + producto.precio}</small>
                </div> 
              </li>
            ))}
          </ul> 
        </div> 
        <div className="col-md-4">
          <h2>Clientes</h2>
          <Link to="/clientes/add" className="btn btn-success mt-3">Registrar cliente</Link>
        </div>
        <div className="col-md-4">
          <h2>Ventas</h2>
          <Link to="/ventas/add" className="btn btn-success mt-3">Registrar Venta</Link>
        </div>
      </div>
    </div>
  );
};

export default Home;
