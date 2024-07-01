import axios from 'axios';
import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const apiUrl = 'http://localhost:8000/ventas';

const useVentas = () => {
  const [ventas, setVentas] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    getAllVentas();
  }, []);

  const getAllVentas = async () => {
    try {
      const res = await axios.get(`${apiUrl}/all`);
      setVentas(res.data);
    } catch (error) {
      handleErrors(error);
    }
  };

  const getVentaById = async (id) => {
    try {
      const res = await axios.get(`${apiUrl}/${id}`);
      return res.data;
    } catch (error) {
      handleErrors(error);
    }
  };

  const saveVenta = async (venta) => {
    try {
      const res = await axios.post(`${apiUrl}/save`, venta, {
        headers: {
          'Content-Type': 'application/json',
        },
      });
      getAllVentas();
      return res.data;
    } catch (error) {
      handleErrors(error);
    }
  };

  const updateVenta = async (id, venta) => {
    try {
      const res = await axios.put(`${apiUrl}/update/${id}`, venta, {
        headers: {
          'Content-Type': 'application/json',
        },
      });
      getAllVentas();
      return res.data;
    } catch (error) {
      handleErrors(error);
    }
  };

  const deleteVenta = async (id) => {
    try {
      await axios.delete(`${apiUrl}/delete/${id}`);
      getAllVentas();
    } catch (error) {
      handleErrors(error);
    }
  };

  const handleErrors = (error) => {
    if (error.response) {
      console.error('Request error:', error.response.data);
      navigate('/error');
    } else if (error.request) {
      console.error('No response from server:', error.request);
      navigate('/error'); 
    } else {
      console.error('Error:', error.message);
      navigate('/error');
    }
  };

  return { ventas, getVentaById, saveVenta, updateVenta, deleteVenta };
};

export default useVentas;
