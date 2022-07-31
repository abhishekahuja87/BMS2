import "react-app-polyfill/ie11";
import "react-app-polyfill/stable";
import React from "react";
import ReactDOM from "react-dom";
import App from "./App";
import "./index.scss";
import "./i18n";
import { I18nextProvider } from "react-i18next";

ReactDOM.render(
  <I18nextProvider>
    <App />
  </I18nextProvider>,
  document.getElementById("root")
);
