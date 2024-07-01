import axios from 'axios';
import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const apiUrl = 'http://localhost:8000/clientes';

const useClientes = () => {
  const [clientes, setClientes] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    getAllClientes();
  }, []);

  const getAllClientes = async () => {
    try {
      const res = await axios.get(`${apiUrl}/all`);
      setClientes(res.data);
    } catch (error) {
      navigate('/notFound');
    }
  };

  const getClienteById = async (id) => {
    try {
      const res = await axios.get(`${apiUrl}/${id}`);
      return res.data;
    } catch (error) {
      navigate('/notFound');
    }
  };

  const saveCliente = async (cliente) => {
    try {
      const res = await axios.post(`${apiUrl}/save`, cliente, {
        headers: {
          'Content-Type': 'application/json',
        },
      });
      getAllClientes();
      return res.data;
    } catch (error) {
      navigate('/notFound');
    }
  };

  const updateCliente = async (id, cliente) => {
    try {
      const res = await axios.put(`${apiUrl}/update/${id}`, cliente, {
        headers: {
          'Content-Type': 'application/json',
        },
      });
      getAllClientes();
      return res.data;
    } catch (error) {
      navigate('/notFound');
    }
  };

  const deleteCliente = async (id) => {
    try {
      await axios.delete(`${apiUrl}/delete/${id}`);
      getAllClientes();
    } catch (error) {
      navigate('/notFound');
    }
  };

  return { clientes, getAllClientes, getClienteById, saveCliente, updateCliente, deleteCliente };
};

export default useClientes;
