// import React from 'react';
// import useFetch from './CustomHook';

// const VentaList = () => {
//   const { data: ventas, loading, error } = useFetch('http://localhost:8000/ventas/all');

//   if (loading) return <p>Loading...</p>;
//   if (error) return <p>Error: {error.message}</p>; 
  
//     return (
//       <div>
//         <h2>Ventas</h2>
//         <ul>
//           {ventas.map((ventas) => (
//             <li key={ventas.id}>{ventas.nombreEvento}</li>
//           ))}
//         </ul>
//       </div>
//     );

// };

// export default VentaList;
