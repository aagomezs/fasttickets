import React from 'react';
import ClienteList from '../components/ClienteList';
import ClienteForm from '../components/ClienteForm';

const ClientesPage = () => {
  return (
    <div>
      <h2>Clientes</h2>
      <ClienteForm />
      <ClienteList />
    </div>
  );
};

export default ClientesPage;
