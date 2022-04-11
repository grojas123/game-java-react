import React, {useEffect, useState} from 'react'
import axios from "axios";
var GameViewBackend='/api/gameview/1'
const tableGridTemplate= [

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
    switch (cellLocation.substring(0,2)) {
       case '01':
            var colum='oneCol'
            break
        case '02':
            var colum='twoCol'
            break
        case '03':
            var colum='thirdCol'
            break
        case '04':
            var colum='fourthCol'
            break
        case '05':
            var colum='fiveCol'
            break
        case '06':
            var colum='sixCol'
            break
        case '07':
            var colum='sevenCol'
            break
        case '08':
            var colum='eighthCol'
            break
        case '09':
            var colum='nineCol'
            break
        case '10':
            var colum='tenCol'
            break
        default:console.log('Invalid col coordinate')
    }
    const row=parseInt(cellLocation.substring(2,4));
    return [row,colum]
}
const GetMapShips=(GameViewGameShips) =>{
    let tableMapWithShips= tableGridTemplate;
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
export const GameViewPlayer = () => {
    const [playerGameView, setPlayerGameView] = useState({});
    const getGameView = () =>axios.get(GameViewBackend)
        .then((response)=>
            {
                //console.log(response);
                const GameViewGameShipsGamer01=response.data[1].ships;
                let mapShipsTemp=GetMapShips(GameViewGameShipsGamer01);
                setPlayerGameView(mapShipsTemp);
                //console.log(playerGameView)
            }
        )
    useEffect(()=>getGameView(),[])
   // console.log(playerGameView)
    var tableGridNoShips=tableGridTemplate;
    return (
        <div>
            <table className="table">
                <thead>
                {tableGameHeader.map(header => {
                    return (
                        <tr key={header.id}><th>{header.firstCol}</th><th>{header.secondCol}</th><th>{header.thirdCol}</th><th>{header.fourthCol}</th>
                            <th>{header.fifthCol}</th><th>{header.sixCol}</th><th>{header.sevenCol}</th><th>{header.eighthCol}</th><th>{header.nineCol}</th>
                            <th>{header.tenCol}</th><th>{header.elevenCol}</th></tr>
                    )
                })}
                </thead>
                <tbody>
                {tableGridNoShips.map(gridRow => {
                return(
                    <tr key={gridRow.row_id}> <td>{gridRow.rowLetter} </td>
                        <td key='oneCol' className={gridRow.oneCol==1 ? 'bg-primary' : ''} >{gridRow.oneCol} </td>
                        <td key='twoCol' className={gridRow.twoCol==1 ? 'bg-primary' : ''} >{gridRow.twoCol}</td>
                        <td key='thirdCol' className={gridRow.thirdCol==1 ? 'bg-primary' : ''}>{gridRow.thirdCol}</td>
                        <td key='fourthCol' className={gridRow.fourthCol==1 ? 'bg-primary' : ''}>{gridRow.fourthCol}</td>
                        <td key='fiveCol' className={gridRow.fiveCol==1 ? 'bg-primary' : ''}>{gridRow.fiveCol}</td>
                        <td key='sixCol' className={gridRow.sixCol==1 ? 'bg-primary' : ''}>{gridRow.sixCol}</td>
                        <td key='sevenCol' className={gridRow.sevenCol==1 ? 'bg-primary' : ''}>{gridRow.sevenCol}</td>
                        <td key='eighthCol' className={gridRow.eighthCol==1 ? 'bg-primary' : ''}>{gridRow.eighthCol}</td>
                        <td key='nineCol' className={gridRow.nineCol==1 ? 'bg-primary' : ''}>{gridRow.nineCol}</td>
                        <td key='tenCol' className={gridRow.tenCol==1 ? 'bg-primary' : ''}>{gridRow.tenCol}</td> </tr>)
                })}
                </tbody>
            </table>
        </div>)

};