import React, { useState, useEffect } from 'react';
import { saveProducto, updateProducto, getProductoById } from '../services/productoService';
import { useNavigate, useParams } from 'react-router-dom';
import HomeButton from './HomeButton';
import ProductoList from './ProductoList';

const ProductoForm = () => {
  const [producto, setProducto] = useState({
    nombreEvento: '',
    lugarEvento: '',
    localidad: '',
    precio: 0
  });
  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    if (id) {
      getProductoById(id).then(data => setProducto(data));
    }
  }, [id]);

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
    navigate('/productos/add');
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

      <ProductoList />

      <div className="mt-4">
        <HomeButton />
      </div>
    </div>
  );
};

export default ProductoForm;
