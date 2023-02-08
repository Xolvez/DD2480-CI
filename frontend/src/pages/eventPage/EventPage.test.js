import { render, screen } from "@testing-library/react";
import EventPage from "./EventPage";

test("renders fetching when fetching", () => {
  render(<EventPage isFetching={true}/>);
  expect(screen.getByText("Fetching")).toBeInTheDocument();
});

test("renders no data when no data", () => {
  render(<EventPage events={[]} />);
  expect(screen.getByText("No data")).toBeInTheDocument();
});

test("renders name of event", () => {
  render(<EventPage events={[ { name: "myNameIsHere", type: "myTypeIsHere" } ]} />);
  expect(screen.getByText("myNameIsHere")).toBeInTheDocument();
});

test("renders type of event", () => {
  render(<EventPage events={[ { name: "myNameIsHere", type: "myTypeIsHere" } ]} />);
  expect(screen.getByText("myTypeIsHere")).toBeInTheDocument();
});

