import React from 'react';
import { HashRouter as Router, Routes, Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import Home from './components/Home';
import './App.css';

import ProductoForm from './components/ProductoForm';
import ClienteForm from './components/ClienteForm';
import VentaForm from './components/VentaForm';

function App() {
  return (
    <Router>
      <div className="app">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/productos/add" element={<ProductoForm />} />
          <Route path="/productos/edit/:id" element={<ProductoForm />} />
          <Route path="/clientes/add" element={<ClienteForm />} />
          <Route path="/clientes/edit/:id" element={<ClienteForm />} />
          <Route path="/ventas/add" element={<VentaForm />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;

 