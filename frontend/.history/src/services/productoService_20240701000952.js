import axios from 'axios';
import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const apiUrl = 'http://localhost:8000/productos';

const useProductos = () => {
  const [productos, setProductos] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    getAllProductos();
  }, []);

  const getAllProductos = async () => {
    try {
      const res = await axios.get(`${apiUrl}/all`);
      setProductos(res.data);
    } catch (error) {
      navigate('/notFound');
    }
  };

  const getProductoById = async (id) => {
    try {
      const res = await axios.get(`${apiUrl}/${id}`);
      return res.data;
    } catch (error) {
      navigate('/notFound');
    }
  };

  const saveProducto = async (producto) => {
    try {
      const res = await axios.post(`${apiUrl}/save`, producto, {
        headers: {
          'Content-Type': 'application/json',
        },
      });
      getAllProductos();
      return res.data;
    } catch (error) {
      navigate('/notFound');
    }
  };

  const updateProducto = async (id, producto) => {
    try {
      const res = await axios.put(`${apiUrl}/update/${id}`, producto, {
        headers: {
          'Content-Type': 'application/json',
        },
      });
      getAllProductos();
      return res.data;
    } catch (error) {
      navigate('/notFound');
    }
  };

  const deleteProducto = async (id) => {
    try {
      await axios.delete(`${apiUrl}/delete/${id}`);
      getAllProductos();
    } catch (error) {
      navigate('/notFound');
    }
  };

  return { productos, getAllProductos, getProductoById, saveProducto, updateProducto, deleteProducto };
};

export default useProductos;
