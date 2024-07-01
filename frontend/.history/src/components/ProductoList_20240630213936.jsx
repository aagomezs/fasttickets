import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { getAllProductos, deleteProducto } from '../services/productoService';

const ProductoList = () => {
  const [productos, setProductos] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetchProductos();
  }, []);

  const fetchProductos = async () => {
    const data = await getAllProductos();
    setProductos(data);
  };

  const handleEdit = (id) => {
    navigate(`/productos/edit/${id}`);
  };

  const handleDelete = async (id) => {
    if (window.confirm('¿Estás seguro de eliminar este producto?')) {
      await deleteProducto(id);
      fetchProductos();
    }
  };

  return (
    <div className="mt-4">
      <h2>Listado de eventos</h2>
      <table className="table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Evento</th>
            <th>Localidad</th>
            <th>Precio</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {productos.map(producto => (
            <tr key={producto.id}>
              <td>{producto.id}</td>
              <td>{producto.nombreEvento}</td>
              <td>{producto.localidad}</td>
              <td>{producto.precio}</td>
              <td>
                <button onClick={() => handleEdit(producto.id)} className="btn btn-sm btn-warning mr-2">Editar</button>
                <button onClick={() => handleDelete(producto.id)} className="btn btn-sm btn-danger">Eliminar</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ProductoList;
