import useSWR from "swr";
const fetcher=(...args)=>fetch(...args).then((resp)=>resp.json());

export const useSwrTest=(GameViewBackendGameid)=>( useSWR(
    GameViewBackendGameid,
    fetcher,
    {
        suspense:true,
    }
))

const GetGameDataBackend=(gameid)=>{
    const GameViewBackendGameid='/api/v2/gameview/'+gameid
    const {data,error}=useSwrTest(GameViewBackendGameid);
    return {
        data: data,
        isLoading: !error && !data,
        isError: error
    }


}
export const GetGameDataBackendv2=(gameid)=>{
    GetGameDataBackend(gameid)
}


export default GetGameDataBackend;