import React from 'react'
import { useParams } from 'react-router-dom'

function EventPage({ events, isFetchingEvents, fetchError }) {

  const eventID = useParams().eventID;
  const event = !events ? null : events.find((event) => event.id === eventID);

  function renderContent() {
    if(isFetchingEvents) {
      return <p>fetching</p>
    }

    if(fetchError) {
      return <p>{fetchError}</p>
    }

    if(!event) {
      return (
        <p>The event could not be found</p>
      );
    }

    return (
      <p>{event.name}</p>
    );
  }

  return (
    <div>
      { renderContent() }
    </div>
  )
}

export default EventPage