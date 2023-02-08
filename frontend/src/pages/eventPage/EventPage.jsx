import React from 'react'

const columns = [
  {
    header: "Name",
    accessor: "name"
  },
  {
    header: "Type",
    accessor: "type"
  }
];

function EventPage({ events, isFetching, fetchError }) {

  function renderEvents() {
    if(isFetching) {
      return (
        <p>Fetching</p>
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
      <table>
        <thead>
          <tr>
            { columns.map((column) => <th key={column.accessor}>{column.header}</th>) }
          </tr>
        </thead>
        <tbody>
          { events.map(event => <tr key={event.id}>
            { columns.map((column) => <td key={column.accessor}>{event[column.accessor]}</td>) }
          </tr>) }
        </tbody>
      </table>
    );
  }
  return (
    <div className="event-page">
      { renderEvents() }
    </div>
  )
}

export default EventPage