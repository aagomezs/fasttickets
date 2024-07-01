import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import useClientes from '../services/clienteService';
import HomeButton from './HomeButton';

const ClienteForm = () => {
  const [cliente, setCliente] = useState({
    nombre: '',
    email: '',
    celular: '',
  });
  const { clientes, getClienteById, saveCliente, updateCliente, deleteCliente } = useClientes(); // Usar el hook personalizado
  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    if (id) {
      getClienteById(id).then(data => setCliente(data));
    }
  }, [id, getClienteById]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setCliente({
      ...cliente,
      [name]: value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (id) {
      await updateCliente(id, cliente);
    } else {
      await saveCliente(cliente);
    }
    navigate('/clientes/add');
  };

  const handleEdit = (id) => {
    navigate(`/clientes/edit/${id}`);
  };

  const handleDelete = async (id) => {
    if (window.confirm('¿Estás seguro de eliminar este cliente?')) {
      await deleteCliente(id);
    }
  };

  return (
    <div>
      <h2>Nuevo cliente</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="nombre"
          value={cliente.nombre}
          onChange={handleChange}
          placeholder="Nombre"
          className="form-control mb-3"
        />
        <input
          type="email"
          name="email"
          value={cliente.email}
          onChange={handleChange}
          placeholder="Correo electrónico"
          className="form-control mb-3"
        />
        <input
          type="number"
          name="celular"
          value={cliente.celular}
          onChange={handleChange}
          placeholder="Celular"
          className="form-control mb-3"
        />
        <button type="submit" className="btn btn-primary">Guardar</button>
        
      </form>

      <div className="mt-4">
        <h2>Listado de Clientes</h2>
        <table className="table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Nombre</th>
              <th>Email</th>
              <th>Celular</th>
              <th>Acciones</th>  
            </tr>
          </thead>
          <tbody>
            {clientes.map(cliente => (
              <tr key={cliente.id}>
                <td>{cliente.id}</td>
                <td>{cliente.nombre}</td>
                <td>{cliente.email}</td>
                <td>{cliente.celular}</td>
                <td>
                  <button onClick={() => handleEdit(cliente.id)} className="btn btn-sm btn-warning mr-2">Editar</button>
                  <button onClick={() => handleDelete(cliente.id)} className="btn btn-sm btn-danger">Eliminar</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      <div className="mt-4">
        <HomeButton />
      </div>
    </div>
  );
};

export default ClienteForm;
