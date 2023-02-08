import { render, screen } from "@testing-library/react";
import EventsPage from "./EventsPage";

test("renders fetching when fetching", () => {
  render(<EventsPage isFetching={true}/>);
  expect(screen.getByText("Fetching")).toBeInTheDocument();
});

test("renders no data when no data", () => {
  render(<EventsPage events={[]} />);
  expect(screen.getByText("No data")).toBeInTheDocument();
});

test("renders name of event", () => {
  render(<EventsPage events={[ { id: "abc", name: "myNameIsHere", type: "myTypeIsHere" } ]} />);
  expect(screen.getByText("myNameIsHere")).toBeInTheDocument();
});

test("renders type of event", () => {
  render(<EventsPage events={[ { id: "abc", name: "myNameIsHere", type: "myTypeIsHere" } ]} />);
  expect(screen.getByText("myTypeIsHere")).toBeInTheDocument();
});

