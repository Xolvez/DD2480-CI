import { render } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import App from './App';
import mockEvents from './consts/mockEvents';

beforeEach(() => {
  fetch.resetMocks();
})

test("navigates to events", () => {
  fetch.mockResponseOnce(JSON.stringify(mockEvents));
  render(
    <BrowserRouter>
      <App />
    </BrowserRouter>
  );

  expect(global.window.location.pathname).toContain("/events");
});
