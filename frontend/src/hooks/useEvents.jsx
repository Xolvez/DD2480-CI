import React from 'react';

function useEvents() {

  const [events, setEvents] = React.useState([]);
  const [isFetching, setIsFetching] = React.useState(false);
  const [isFetched, setIsFetched] = React.useState(false);
  const [error, setError] = React.useState();

  React.useEffect(() => {
    async function fetchEvents() {
      try {
        setIsFetching(true);

        // Simulate delay
        await new Promise((resolve) => setTimeout(resolve, 3000));

        const response = await fetch("http://localhost:8080/build", {
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

  function refetch() {
    setIsFetched(false);
    setIsFetching(false);
    setError(null);
  }

  return { events, isFetching: isFetching || (!isFetched && !isFetching), isFetched, fetchError: error, refetch };
}

export default useEvents