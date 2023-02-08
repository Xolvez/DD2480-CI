import React from 'react';
import { useNavigate } from 'react-router-dom';
import "./eventsPage.css";
import { FaSync } from "react-icons/fa";

const columns = [
  {
    header: "Commit ID",
    accessor: "commitID"
  },
  {
    header: "Build Date",
    accessor: "build_date"
  },
  {
    header: "Build Status",
    accessor: "build_success"
  }
];

function EventsPage({ events, isFetching, fetchError, refetch }) {

  const navigate = useNavigate();

  function handleClick(eventID) {
    navigate("/event/" + eventID);
  }

  function renderEvents() {
    if(isFetching) {
      return (
        <div className="events-fetching-container">
          <FaSync className="spinner" />
          <p>Fetching</p>
        </div>
      );
    }

    if(fetchError) {
      return <p>{fetchError}</p>
    }

    if(events.length === 0) {
      return (
        <p>No data</p>
      );
    }

    return (
      <>
        <table className="events-table">
          <thead>
            <tr>
              { columns.map((column) => <th key={column.accessor}>{column.header}</th>) }
            </tr>
          </thead>
          <tbody>
            { events.map(event => <tr key={event.id} onClick={() => handleClick(event.id)}>
              <td>{event.commitID}</td>
              <td>{event.build_date}</td>
              <td className="events-td-success">
                <div className="events-td-event-status" success={event.build_success.toString()}>
                  {event.build_success ? "Success" : "Failure"}
                </div>
              </td>
            </tr>) }
          </tbody>
        </table>
        <div className="space-filler"></div>
      </>
    );
  }
  return (
    <div className="events-page">
      <div className="events-header-container">
        <h1>Events</h1>
        <button disabled={isFetching} onClick={refetch}>
          <FaSync />
          <p>Refetch</p>
        </button>
      </div>
      <div className="events-table-container">
        { renderEvents() }
      </div>
    </div>
  )
}

export default EventsPage