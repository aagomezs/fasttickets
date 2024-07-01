import React, { useState, useEffect } from 'react';
import { saveProducto, updateProducto, getProductoById, getAllProductos, deleteProducto } from '../services/productoService';
import { useNavigate, useParams } from 'react-router-dom';
import ProductoList from './ProductoList';
import HomeButton from './HomeButton';

const ProductoForm = () => {
  const [producto, setProducto] = useState({ id: '', nombreEvento: '', lugarEvento: '', localidad: '', precio: '' });
  const [productos, setProductos] = useState([]);
  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    const fetchProducto = async () => {
      if (id) {
        const producto = await getProductoById(id);
        setProducto(producto);
      }
      const productos = await getAllProductos();
      setProductos(productos);
    };

    fetchProducto();
  }, [id]);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setProducto({ ...producto, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (id) {
      const updatedProducto = await updateProducto(id, producto);
      setProductos(productos.map(p => (p.id === id ? updatedProducto : p)));  
    } else {
      const newProducto = await saveProducto(producto);
      setProductos([...productos, newProducto]);  
    }
    setProducto({ id: '', nombreEvento: '', lugarEvento: '', localidad: '', precio: '' });  
  };

  const handleDelete = async (id) => {
    if (window.confirm('¿Estás seguro de eliminar este producto?')) {
      await deleteProducto(id);
      setProductos(productos.filter(producto => producto.id !== id));
    }
  };

  return (
    <div>
      <h2>{id ? 'Editar evento' : 'Nuevo evento'}</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Nombre del Evento</label>
          <input type="text" className="form-control" name="nombreEvento" value={producto.nombreEvento} onChange={handleInputChange} required />
        </div>
        <div className="form-group">
          <label>Lugar del Evento</label>
          <input type="text" className="form-control" name="lugarEvento" value={producto.lugarEvento} onChange={handleInputChange} required />
        </div>
        <div className="form-group">
          <label>Localidad</label>
          <input type="text" className="form-control" name="localidad" value={producto.localidad} onChange={handleInputChange} required />
        </div>
        <div className="form-group">
          <label>Precio</label>
          <input type="number" className="form-control" name="precio" value={producto.precio} onChange={handleInputChange} required />
        </div>
        <button type="submit" className="btn btn-primary">Guardar</button>
      </form>

      <ProductoList productos={productos} onDelete={handleDelete} />

      <div className="mt-4">
        <HomeButton />
      </div>
    </div>
  );
};

export default ProductoForm;
