import axios from 'axios';

const apiUrl = 'http://localhost:8000/ventas';

export const saveVenta = async (venta) => {
  try {
    const response = await axios.post(`${apiUrl}/save`, venta, {
      headers: {
        'Content-Type': 'application/json',
      },
    });
    return response.data;
  } catch (error) {
    console.error('Error al guardar la venta:', error);
    throw error; 
  }
};

export const getAllVentas = async () => {
  try {
    const response = await axios.get(`${apiUrl}/all`);
    return response.data;
  } catch (error) {
    console.error('Error al obtener las ventas:', error);
    throw error;  
  }
};

export const getVentaById = async (id) => {
  try {
    const response = await axios.get(`${apiUrl}/${id}`);
    return response.data;
  } catch (error) {
    console.error(`Error al obtener la venta con ID ${id}:`, error);
    throw error;  
  }
};

export const updateVenta = async (id, venta) => {
  try {
    const response = await axios.put(`${apiUrl}/update/${id}`, venta, {
      headers: {
        'Content-Type': 'application/json',
      },
    });
    return response.data;
  } catch (error) {
    console.error(`Error al actualizar la venta con ID ${id}:`, error);
    throw error;  
  }
};

export const deleteVenta = async (id) => {
  try {
    await axios.delete(`${apiUrl}/delete/${id}`);
  } catch (error) {
    console.error(`Error al eliminar la venta con ID ${id}:`, error);
    throw error;  
  }
};
