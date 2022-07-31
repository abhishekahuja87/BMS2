import React, { Component } from "react";
import "primereact/resources/themes/nova-light/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";
import MainPage from "./JSXComponents/MainPage";
import "typeface-roboto";
import "antd/dist/antd.css";
import { withTranslation } from "react-i18next";

class App extends Component {
  // constructor() {
  //   super();
  // }

  componentWillMount() {
    const { i18n } = this.props;
    i18n.changeLanguage(
      window.navigator.userLanguage || window.navigator.language
    );
  }

  render() {
    return (
      <React.Fragment>
        <MainPage />
      </React.Fragment>
    );
  }
}

// export default App;
export default withTranslation()(App);
