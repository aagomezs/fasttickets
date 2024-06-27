import React from 'react';
import VentaList from '../components/VentaList';
import VentaForm from '../components/VentaForm';

const VentasPage = () => {
  return (
    <div>
      <h2>Ventas</h2>
      <VentaForm />
      <VentaList />
    </div>
  );
};

export default VentasPage;
