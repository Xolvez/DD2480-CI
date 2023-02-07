import { render, screen } from '@testing-library/react';
import App from './App';

test('renders hello world string', () => {
  render(<App />);
  const appElement = screen.getByText("Hello world!")
  expect(appElement).toBeInTheDocument();
});
