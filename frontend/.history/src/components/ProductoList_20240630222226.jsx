// import React from 'react';
// import { Link } from 'react-router-dom';

// const ProductoList = ({ productos, onDelete }) => {
//   return (
//     <div className="mt-4">
//       <h2>Listado de eventos</h2>
//       <ul className="list-group">
//         {productos.map(producto => (
//           <li key={producto.id} className="list-group-item d-flex justify-content-between align-items-center">
//             <div>
//               {producto.nombreEvento}
//               <br />
//               <small>{producto.lugarEvento} - {producto.localidad} - {producto.precio}</small>
//             </div>
//             <div>
//               <Link to={`/productos/${producto.id}`} className="btn btn-sm btn-primary mr-2">Editar</Link>
//               <button onClick={() => onDelete(producto.id)} className="btn btn-sm btn-danger">Eliminar</button>
//             </div>
//           </li>
//         ))}
//       </ul>
//     </div>
//   );
// };

// export default ProductoList;
