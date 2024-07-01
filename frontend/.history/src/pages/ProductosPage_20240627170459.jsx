import React from 'react';
import ProductoList from '../components/ProductoList';
import ProductoForm from '../components/ProductoForm';

const ProductosPage = () => {
  return (
    <div>
      <h2>Productos</h2>
      <ProductoForm />
      <ProductoList />
    </div>
  );
};

export default ProductosPage;
