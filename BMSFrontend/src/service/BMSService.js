
// export class AgentService {

import axios from "axios"

class BMSService {

    nowPlaying() {
        return axios.get("https://reqres.in/api/articles");
            // .then(res => 
            //     {
            //          return res;             
            //     })
      }

}
export default new BMSService();