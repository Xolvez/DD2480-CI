import { render, screen } from "@testing-library/react";
import { BrowserRouter } from "react-router-dom";
import EventPage from "./EventPage";

beforeEach(() => {
  jest.clearAllMocks();
});

afterEach(() => {
  jest.clearAllMocks();
});

function mockUseParamsWithEventID(mockEventID) {
  jest.mock("react-router-dom", () => ({
    ...jest.requireActual("react-router-dom"),
    useParams: () => ({
      eventID: mockEventID
    }),
    //useRouteMatch: () => ({ url: "/event/eventID" })
  }));
}

test("renders fetching if fetching", () => {
  mockUseParamsWithEventID("abc");
  render(<EventPage isFetchingEvents={true} />);
  expect(screen.getByText("fetching")).toBeInTheDocument();
});

test("renders error if error", () => {
  mockUseParamsWithEventID("abc");
  render(<EventPage isFetchingEvents={false} fetchError={"could not fetch"} />);
  expect(screen.getByText("could not fetch")).toBeInTheDocument();
});

test("renders could not be found if could not be found", () => {
  mockUseParamsWithEventID("abc");
  render(<EventPage events={ [] } isFetchingEvents={false} fetchError={null} />);
  expect(screen.getByText("The event could not be found")).toBeInTheDocument();
});