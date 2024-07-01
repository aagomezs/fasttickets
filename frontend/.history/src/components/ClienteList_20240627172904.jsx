// import React from 'react';
// import useFetch from './CustomHook';

// const ClienteList = () => {
//   const { data: clientes, loading, error } = useFetch('http://localhost:8000/clientes/all');

//   if (loading) return <p>Loading...</p>;
//   if (error) return <p>Error: {error.message}</p>;

//   return (
//     <div>
//       <h2>Clientes</h2>
//       <ul>
//         {clientes.map((cliente) => (
//           <li key={cliente.id}>{cliente.nombre}</li>
//         ))}
//       </ul>
//     </div>
//   );
// };

// export default ClienteList;
