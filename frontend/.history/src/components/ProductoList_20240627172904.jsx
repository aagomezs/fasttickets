// import React, { useEffect, useState } from 'react';
// import { Link } from 'react-router-dom';
// import { getAllProductos, deleteProducto } from '../services/productoService';

// const ProductoList = () => {
//   const [productos, setProductos] = useState([]);

//   useEffect(() => {
//     getAllProductos().then(data => setProductos(data));
//   }, []);

//   const handleDelete = async (id) => {
//     await deleteProducto(id);
//     setProductos(productos.filter(producto => producto.id !== id));
//   };

//   return (
//     <div className="container">
//       <h2>Lista de Productos</h2>
//       <Link to="/productos/add" className="btn btn-primary mb-3">Agregar Producto</Link>
//       <ul className="list-group">
//         {productos.map(producto => (
//           <li key={producto.id} className="list-group-item d-flex justify-content-between align-items-center">
//             {producto.nombreEvento}
//             <div>
//               <Link to={`/productos/edit/${producto.id}`} className="btn btn-secondary btn-sm mr-2">Editar</Link>
//               <button onClick={() => handleDelete(producto.id)} className="btn btn-danger btn-sm">Eliminar</button>
//             </div>
//           </li>
//         ))}
//       </ul>
//     </div>
//   );
// };

// export default ProductoList;
