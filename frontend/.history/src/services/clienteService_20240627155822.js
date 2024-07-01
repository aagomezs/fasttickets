import axios from 'axios';

const apiUrl = 'http://localhost:8000/clientes';

export const getAllClientes = async () => {
  const response = await axios.get(`${apiUrl}/all`);
  return response.data;
};

export const getClienteById = async (id) => {
  const response = await axios.get(`${apiUrl}/${id}`);
  return response.data;
};

export const saveCliente = async (cliente) => {
  const response = await axios.post(`${apiUrl}/save`, cliente, {
    headers: {
      'Content-Type': 'application/json',
    },
  });
  return response.data;
};

export const updateCliente = async (id, cliente) => {
  const response = await axios.put(`${apiUrl}/update/${id}`, cliente, {
    headers: {
      'Content-Type': 'application/json',
    },
  });
  return response.data;
};

export const deleteCliente = async (id) => {
  await axios.delete(`${apiUrl}/delete/${id}`);
};