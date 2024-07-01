import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import useProductos from '../services/productoService';
import HomeButton from './HomeButton';

const ProductoForm = () => {
  const [producto, setProducto] = useState({
    nombreEvento: '',
    lugarEvento: '',
    localidad: '',
    precio: 0
  });
  const { productos, saveProducto, updateProducto, deleteProducto, getProductoById, getAllProductos } = useProductos();
  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    if (id) {
      getProductoById(id).then(data => setProducto(data));
    }
    fetchProductos();
  }, [id]);

  const fetchProductos = async () => {
    await getAllProductos(); 
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProducto({
      ...producto,
      [name]: value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (id) {
      await updateProducto(id, producto);
    } else {
      await saveProducto(producto);
    }
    fetchProductos();
    navigate('/productos/add');
    setProducto({
      nombreEvento: '',
      lugarEvento: '',
      localidad: '',
      precio: 0
    });
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
    <div>
      <h2>Nuevo evento</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="nombreEvento"
          value={producto.nombreEvento}
          onChange={handleChange}
          placeholder="Nombre del Evento"
          className="form-control mb-3"
        />
        <input
          type="text"
          name="lugarEvento"
          value={producto.lugarEvento}
          onChange={handleChange}
          placeholder="Lugar del Evento"
          className="form-control mb-3"
        />
        <input
          type="text"
          name="localidad"
          value={producto.localidad}
          onChange={handleChange}
          placeholder="Localidad"
          className="form-control mb-3"
        />
        <input
          type="number"
          name="precio"
          value={producto.precio}
          onChange={handleChange}
          placeholder="Precio"
          className="form-control mb-3"
        />
        <button type="submit" className="btn btn-primary">Guardar</button>
      </form>

      <div className="mt-4">
        <h2>Listado de eventos</h2>
        <table className="table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Evento</th>
              <th>Lugar</th>
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
                <td>{producto.lugarEvento}</td>
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

      <div className="mt-4">
        <HomeButton />
      </div>
    </div>
  );
};

export default ProductoForm;
