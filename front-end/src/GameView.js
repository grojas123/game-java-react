import React, {useEffect, useState} from 'react'
import axios from "axios";
import {useParams} from "react-router";
var GameViewBackend='/api/gameview/'
const tableGridTemplateShips= [

    {
        row_id:0,
        rowLetter:"A",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },

    {
        row_id:1,
        rowLetter:"B",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },

    {
        row_id:2,
        rowLetter:"C",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },

    {
        row_id:3,
        rowLetter:"D",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },

    {
        row_id:4,
        rowLetter:"E",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },

    {
        row_id:5,
        rowLetter:"F",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },
    {
        row_id:6,
        rowLetter:"G",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },

    {
        row_id:7,
        rowLetter:"H",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },

    {
        row_id:8,
        rowLetter:"I",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },
    {
        row_id:9,
        rowLetter:"J",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    }
]
const tableGridTemplateSalvoes= [

    {
        row_id:0,
        rowLetter:"A",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },

    {
        row_id:1,
        rowLetter:"B",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },

    {
        row_id:2,
        rowLetter:"C",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },

    {
        row_id:3,
        rowLetter:"D",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },

    {
        row_id:4,
        rowLetter:"E",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },

    {
        row_id:5,
        rowLetter:"F",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },
    {
        row_id:6,
        rowLetter:"G",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },

    {
        row_id:7,
        rowLetter:"H",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },

    {
        row_id:8,
        rowLetter:"I",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    },
    {
        row_id:9,
        rowLetter:"J",
        oneCol:0,
        twoCol:0,
        thirdCol:0,
        fourthCol:0,
        fiveCol:0,
        sixCol:0,
        sevenCol:0,
        eighthCol:0,
        nineCol:0,
        tenCol:0
    }
]
var boardplayers=[
    {
        playerNumber:0,
        firstName:'',
        lastName:'',
        email:''
},
    {
        playerNumber:1,
        firstName:'',
        lastName:'',
        email:''
    }
]

const tableGameHeader= [
    {
        id: "01",
        firstCol:"Row letter",
        secondCol:1,
        thirdCol:2,
        fourthCol:3,
        fifthCol:4,
        sixCol:5,
        sevenCol:6,
        eighthCol:7,
        nineCol:8,
        tenCol:9,
        elevenCol:10
    }
]
const GetCoordinatesCell=(cellLocation)=>{
    let colum='';
    switch (cellLocation.substring(0,2)) {
       case '01':
            colum='oneCol'
            break
        case '02':
            colum='twoCol'
            break
        case '03':
            colum='thirdCol'
            break
        case '04':
            colum='fourthCol'
            break
        case '05':
            colum='fiveCol'
            break
        case '06':
            colum='sixCol'
            break
        case '07':
            colum='sevenCol'
            break
        case '08':
            colum='eighthCol'
            break
        case '09':
            colum='nineCol'
            break
        case '10':
            colum='tenCol'
            break
        default:console.log('Invalid col coordinate')
    }
    const row=parseInt(cellLocation.substring(2,4));
    return [row,colum]
}
const GetMapShips=(GameViewGameShips) =>{
    let tableMapWithShips= tableGridTemplateShips;
    GameViewGameShips.map(
        ship=>{ ship.locations.map(cellLocation=> {
                var pointCoordinates= GetCoordinatesCell(cellLocation)
                var row=pointCoordinates[0];
                var column=pointCoordinates[1];
                tableMapWithShips[row-1][column]=1;
            }
            )
            })
    return tableMapWithShips;
}
export const GameBoard = () => {
    var { gameid,gamernumber } = useParams();
    return (
        <div>{PlayerShipsBoard(gameid,gamernumber)} {PlayerSalvoesBoard(gameid,gamernumber)}</div>
    )

};

const PlayerShipsBoard=(gameid,gamernumber) =>{
    var otherplayernumber=1-gamernumber;
    const GameViewBackendWithGameid=GameViewBackend+gameid;
    const [, setPlayerShips] = useState({});
    const getGameView = () =>axios.get(GameViewBackendWithGameid)
        .then((response)=>
            {
                const GameViewGameShipsGamer=response.data[gamernumber].ships;
                boardplayers[gamernumber].email =response.data[gamernumber].player.email;
                boardplayers[otherplayernumber].email =response.data[otherplayernumber].player.email;
                //console.log(boardplayers[gamernumber].email,' ',boardplayers[otherplayernumber].email)
                let mapShipsTemp=GetMapShips(GameViewGameShipsGamer);
                setPlayerShips(mapShipsTemp);

            }
        )

    useEffect(()=>getGameView(),tableGridTemplateShips)

    let tableGridNoShips=tableGridTemplateShips;
    return (

        <div>

            <table className="table table-borderless table-responsive ">
                <caption className='caption-top fw-bolder' >Player {boardplayers[gamernumber].email} <b>Ships</b> vs {boardplayers[otherplayernumber].email} </caption>

                <thead>

                {tableGameHeader.map(header => {
                    return (
                        <tr key={header.id}>

                            <th>{header.firstCol}</th><th>{header.secondCol}</th><th>{header.thirdCol}</th><th>{header.fourthCol}</th>
                            <th>{header.fifthCol}</th><th>{header.sixCol}</th><th>{header.sevenCol}</th><th>{header.eighthCol}</th><th>{header.nineCol}</th>
                            <th>{header.tenCol}</th><th>{header.elevenCol}</th>
                        </tr>

                    )
                })}
                </thead>
                <tbody>
                {tableGridNoShips.map(gridRow => {
                    return(
                        <tr key={gridRow.row_id}><td>{gridRow.rowLetter}</td>
                            <td key='oneCol' className={gridRow.oneCol===1 ? 'bg-primary':''}>{gridRow.oneCol} </td>
                            <td key='twoCol' className={gridRow.twoCol===1 ? 'bg-primary':''}>{gridRow.twoCol}</td>
                            <td key='thirdCol' className={gridRow.thirdCol===1 ? 'bg-primary':''}>{gridRow.thirdCol}</td>
                            <td key='fourthCol' className={gridRow.fourthCol===1 ? 'bg-primary':''}>{gridRow.fourthCol}</td>
                            <td key='fiveCol' className={gridRow.fiveCol===1 ? 'bg-primary':''}>{gridRow.fiveCol}</td>
                            <td key='sixCol' className={gridRow.sixCol===1 ? 'bg-primary':''}>{gridRow.sixCol}</td>
                            <td key='sevenCol' className={gridRow.sevenCol===1 ? 'bg-primary':''}>{gridRow.sevenCol}</td>
                            <td key='eighthCol' className={gridRow.eighthCol===1 ? 'bg-primary':''}>{gridRow.eighthCol}</td>
                            <td key='nineCol' className={gridRow.nineCol===1 ? 'bg-primary':''}>{gridRow.nineCol}</td>
                            <td key='tenCol' className={gridRow.tenCol===1 ? 'bg-primary':''}>{gridRow.tenCol}</td></tr>)
                })}
                </tbody>
            </table>
        </div>)




};
const GetMapSalvoes=(GameViewGameShips) =>{
    let tableMapWithSalvoes= tableGridTemplateSalvoes;
    GameViewGameShips.map(
        ship=>{ ship.locations.map(cellLocation=> {
                var pointCoordinates= GetCoordinatesCell(cellLocation)
                var row=pointCoordinates[0];
                var column=pointCoordinates[1];
                tableMapWithSalvoes[row-1][column]=2;
            }
        )
        })
    return tableMapWithSalvoes;
}
const PlayerSalvoesBoard=(gameid,gamernumber) =>{
    var otherplayernumber=1-gamernumber;
    const GameViewBackendWithGameid=GameViewBackend+gameid;
    const [, setSalvoes] = useState({});
    const getGameView = () =>axios.get(GameViewBackendWithGameid)
        .then((response)=>
            {
                const GameViewGameShipsGamer=response.data[gamernumber].salvoes;
                boardplayers[gamernumber].email =response.data[gamernumber].player.email;
                boardplayers[otherplayernumber].email =response.data[otherplayernumber].player.email;
                //console.log(boardplayers[gamernumber].email,' ',boardplayers[otherplayernumber].email)
                let mapSalvoesTemp=GetMapSalvoes(GameViewGameShipsGamer);
                setSalvoes(mapSalvoesTemp);

            }
        )

    useEffect(()=>getGameView(),tableGridTemplateShips)

    let tableGridNoSalvoes=tableGridTemplateSalvoes;
    return (

        <div>

            <table className="table table-borderless table-responsive ">
                <caption className='caption-top fw-bolder' >Player {boardplayers[gamernumber].email} <b>Salvoes</b> vs {boardplayers[otherplayernumber].email} </caption>

                <thead>

                {tableGameHeader.map(header => {
                    return (
                        <tr key={header.id}>

                            <th>{header.firstCol}</th><th>{header.secondCol}</th><th>{header.thirdCol}</th><th>{header.fourthCol}</th>
                            <th>{header.fifthCol}</th><th>{header.sixCol}</th><th>{header.sevenCol}</th><th>{header.eighthCol}</th><th>{header.nineCol}</th>
                            <th>{header.tenCol}</th><th>{header.elevenCol}</th>
                        </tr>

                    )
                })}
                </thead>
                <tbody>
                {tableGridNoSalvoes.map(gridRow => {
                    return(
                        <tr key={gridRow.row_id}><td>{gridRow.rowLetter}</td>
                            <td key='oneCol' className={gridRow.oneCol===2 ? 'bg-danger':''}>{gridRow.oneCol} </td>
                            <td key='twoCol' className={gridRow.twoCol===2 ? 'bg-danger':''}>{gridRow.twoCol}</td>
                            <td key='thirdCol' className={gridRow.thirdCol===2 ? 'bg-danger':''}>{gridRow.thirdCol}</td>
                            <td key='fourthCol' className={gridRow.fourthCol===2 ? 'bg-danger':''}>{gridRow.fourthCol}</td>
                            <td key='fiveCol' className={gridRow.fiveCol===2 ? 'bg-danger':''}>{gridRow.fiveCol}</td>
                            <td key='sixCol' className={gridRow.sixCol===2 ? 'bg-danger':''}>{gridRow.sixCol}</td>
                            <td key='sevenCol' className={gridRow.sevenCol===2 ? 'bg-danger':''}>{gridRow.sevenCol}</td>
                            <td key='eighthCol' className={gridRow.eighthCol===2 ? 'bg-danger':''}>{gridRow.eighthCol}</td>
                            <td key='nineCol' className={gridRow.nineCol===2 ? 'bg-danger':''}>{gridRow.nineCol}</td>
                            <td key='tenCol' className={gridRow.tenCol===2 ? 'bg-danger':''}>{gridRow.tenCol}</td></tr>)
                })}
                </tbody>
            </table>
        </div>)

};

