import axios from "axios";
import React, { useEffect, useState } from "react";
import { Card } from "antd";
import { Button, Modal } from "antd";
import { Collapse } from "antd";
import { Input } from 'antd';
// import BMSService from "../service/BMSService"

function NowPlaying() {
  const { Panel } = Collapse;

  const [nowPlayingSt, setnowPlayingSt] = useState([]);
  const [activeTabMovieDetail, setActiveTabMovieDetail] = useState(undefined);
  const [showBookMovieDialog, setShowBookMovieDialog] = useState(undefined);
  const [bookMovieDetails, setBookMovieDetails] = useState(undefined);

  useEffect(() => {
    const headers = {
      Accept: "application/json",
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Header": "*",
    };
    axios
      .get("http://localhost:8080/movies/nowplaying", {
        headers: headers,
      })
      .then((res) => {
        console.log("a");
        setnowPlayingSt(res.data);
      });
  }, []);

  const onChange = (key) => {
    console.log(key);
    axios.get("http://localhost:8080/movies/shows/1", {}).then((res) => {
      console.log("a");
      setActiveTabMovieDetail(res.data);
    });
  };

  const onBookMovieClick = (e, mName, time, price) => {
    console.log(e);
    console.log(mName);
    console.log(time);
    console.log(price);
    setBookMovieDetails({ movieName: mName, time: time, price: price });
    setShowBookMovieDialog(true);
  };

  const handleOk = () => {
    setShowBookMovieDialog(false);    
  };

  const handleCancel = () => {
    setShowBookMovieDialog(false);
  };

  const getBookMovieModal = () => {
    if (bookMovieDetails) {
      return (
        <Modal
          title={bookMovieDetails.movieName + " | " + bookMovieDetails.time + " | "  + "Rs " + bookMovieDetails.price}
          visible={showBookMovieDialog}
          onOk={handleOk}
          onCancel={handleCancel}
        >
            <Input placeholder="Enter number of tickets to book" />

        </Modal>
      );
    }
  };

  return (
    <div>
      <Collapse
        className="movies-acc"
        accordion
        defaultActiveKey={[]}
        onChange={onChange}
      >
        {nowPlayingSt.map((m) => (
          <Panel header={m.name} key={m.id}>
            {activeTabMovieDetail && (
              <div>
                <h3>{activeTabMovieDetail.showDate}</h3>
                {activeTabMovieDetail.theatres.map((th) => {
                  return (
                    <div>
                      <h3>{th.theatreName}</h3>
                      {th &&
                        th.screens.map((sc) => {
                          return (
                            <div style={{ marginLeft: "15px" }}>
                              {sc.screenName}
                              {sc.showtimes.map((st, i) => {
                                return (
                                  <Button
                                    id={i}
                                    key={i}
                                    type="link"
                                    size="small"
                                    onClick={(e) =>
                                      onBookMovieClick(
                                        e,
                                        m.name,
                                        st,
                                        sc.ticketPrice
                                      )
                                    }
                                  >
                                    {st} | Rs {sc.ticketPrice}
                                  </Button>
                                );
                              })}
                            </div>
                          );
                        })}
                    </div>
                  );
                })}
              </div>
            )}
          </Panel>
        ))}
      </Collapse>
      {getBookMovieModal()}
    </div>
  );
}

export default NowPlaying;
