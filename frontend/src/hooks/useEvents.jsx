import React from 'react';

const testEvents = [
  {
    id: "1",
    commitID: "abc",
    build_date: "JAN 9",
    build_success: true,
    build_message: ""
  },
  {
    id: "2",
    commitID: "def",
    build_date: "OCT 23",
    build_success: false,
    build_message: "Unable to build due to this ..."
  },
  {
    id: "3",
    commitID: "ghi",
    build_date: "FEB 17",
    build_success: true,
    build_message: ""
  },
  {
    id: "4",
    commitID: "klm",
    build_date: "DEC 4",
    build_success: false,
    build_message: "Build error: insert error here"
  }
];

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
        /*
        setError("Unable to fetch events");
        setIsFetched(true);
        setIsFetching(false);
        */
       setEvents(testEvents);
       setIsFetching(false);
       setIsFetched(true);
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