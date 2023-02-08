import React from 'react'
import { FaSkullCrossbones, FaSync } from 'react-icons/fa';
import { useParams } from 'react-router-dom'
import "./eventPage.css";

function EventPage({ events, isFetchingEvents, fetchError }) {

  const eventID = useParams().eventID;
  const event = !events ? null : events.find((event) => event.id === eventID);

  function renderContent() {
    if(isFetchingEvents) {
      return (
        <div className="event-alternative">
          <div>
            <FaSync className="spinner" />
            <p>Loading event data</p>
          </div>
        </div>
        
      );
    }

    if(fetchError) {
      return (
        <div className="event-alternative">
          <p>{fetchError}</p>
        </div>
      );
    }

    if(!event) {
      return (
        <div className="event-alternative">
          <div>
            <FaSkullCrossbones />
            <p>The event could not be found</p>
          </div>
        </div>
      );
    }

    return (
      <div>
        <p>Commit ID</p>
        <input type="text" disabled value={event.commitID} />

        <p>Status</p>
        <div className="event-status" success={event.build_success.toString()}>{event.build_success ? "Success" : "Failure"}</div>
        
        { !event.build_success && 
            <div>
              <p>Reason</p>
              <textarea disabled value={event.build_message}></textarea>
            </div>
        }

        <p>Build Date</p>
        <input type="text" disabled value={event.build_date}/>
      </div>
    );
  }

  return (
    <div className="event-page">
      <div className="event-header">
        <h1>Event</h1>
        <p>Id: {eventID}</p>
      </div>
      { renderContent() }
    </div>
  )
}

export default EventPage