import React from 'react'

function useEvents() {

  const [events, setEvents] = React.useState();
  const [isFetching, setIsFetching] = React.useState(false);
  const [isFetched, setIsFetched] = React.useState(false);
  const [error, setError] = React.useState();

  React.useEffect(() => {
    async function fetchEvents() {
      try {
        setIsFetching(true);

        const response = await fetch("http://localhost:8080/events", {
          method: "GET"
        });

        if(response.status !== 200) {
          // Error
          setError("Unable to fetch events");
          setIsFetched(true);
          setIsFetching(false);
          return;
        }

        const events = await response.json();

        setEvents(events);
        setIsFetched(true);
        setIsFetching(false);
      }
      catch(error) {
        setError("Unable to fetch events");
        setIsFetched(true);
        setIsFetching(false);
      }
      
    }

    if(!isFetched && !isFetching) {
      fetchEvents();
    }
  }, [isFetched, isFetching]);


  return { events, isFetching: isFetching || (!isFetched && !isFetching), isFetched, fetchError: error };
}

export default useEvents