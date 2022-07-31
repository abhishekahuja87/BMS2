import React, { Component } from "react";
import { ProgressSpinner } from "primereact/progressspinner";
import axios from "axios";
import Navbar from "./Navbar";
import i18n from "../i18n";
import NowPlaying from "./NowPlaying";

class MainPage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      // axiosExportFailure: false
    };
  }

  componentDidMount() {
  }  

  render() {    
    return (
      <div role="main">
        <Navbar/>
        <NowPlaying />
      </div>
    );
  }
}

export default MainPage;
