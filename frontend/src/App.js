import React from 'react';
import { Navigate, Route, Routes } from 'react-router-dom';
import './App.css';
import useEvents from './hooks/useEvents';
import EventPage from './pages/eventPage/EventPage';

function App() {

  const { events, isFetching, isFetched, fetchError } = useEvents();

  return (
    <div className="app">
      <Routes>
        <Route path="events" element={ <EventPage events={events} isFetching={isFetching} isFetched={isFetched} fetchError={fetchError} /> } />
        <Route path="*" element={ <Navigate to="events" /> } />
      </Routes>
    </div>
  );
}

export default App;
