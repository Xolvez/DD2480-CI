import { render, screen } from "@testing-library/react";
import { BrowserRouter } from "react-router-dom";
import EventsPage from "./EventsPage";

test("renders fetching when fetching", () => {
  render(
    <BrowserRouter> 
      <EventsPage isFetching={true}/>
    </BrowserRouter>     
  );
  expect(screen.getByText("Fetching")).toBeInTheDocument();
});

test("renders no data when no data", () => {
  render(
    <BrowserRouter>
      <EventsPage events={[]} />
    </BrowserRouter>     
  );
      
  expect(screen.getByText("No data")).toBeInTheDocument();
});

test("renders commitID of event", () => {
  render(
    <BrowserRouter>
      <EventsPage events={[
        {
          id: "eventID",
          commitID: "commit_id",
          build_date: "JAN 9",
          build_success: true,
          build_message: ""
        }
      ]} isFetching={false} fetchError={false}/>
    </BrowserRouter>  
  );
  expect(screen.getByText("commit_id")).toBeInTheDocument();
});

test("renders success if successful build event", () => {
  render(
    <BrowserRouter>
      <EventsPage events={[
        {
          id: "eventID",
          commitID: "commit_id",
          build_date: "JAN 9",
          build_success: true,
          build_message: ""
        }
      ]} isFetching={false} fetchError={false} />
    </BrowserRouter>
  );
  expect(screen.getByText("Success")).toBeInTheDocument();
});

