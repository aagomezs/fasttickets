import axios from 'axios';
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const apiUrl = 'http://localhost:8000/productos';

const Producto = (props) => {
  let headers = props.headers
  const navigate = useNavigate();
  const[Producto, setProducto] = useState([]);
  useEffect(()=>{
    getAllProductos()

  },[]);

  const getAllProductos = async() => {
    try{
      const res = await axios({
        method: "GET",
        url: apiUrl,
        headers: headers
      });
      setProducto(res.data)
    }catch(error){
      navigate("/notFound")
    }
  
  }
 
}





// export const getAllProductos = async () => {
//   const response = await axios.get(`${apiUrl}/all`);
//   return response.data;
// };

export const getProductoById = async (id) => {
  const response = await axios.get(`${apiUrl}/${id}`);
  return response.data;
};

export const saveProducto = async (producto) => {
  const response = await axios.post(`${apiUrl}/save`, producto, {
    headers: {
      'Content-Type': 'application/json',
    },
  });
  return response.data;
};

export const updateProducto = async (id, producto) => {
  const response = await axios.put(`${apiUrl}/update/${id}`, producto, {
    headers: {
      'Content-Type': 'application/json',
    },
  });
  return response.data;
};

export const deleteProducto = async (id) => {
  await axios.delete(`${apiUrl}/delete/${id}`);
};