import React, {useEffect} from "react";
import {GridStack} from "gridstack";
import 'gridstack/dist/gridstack.css';
import 'gridstack/dist/h5/gridstack-dd-native';
import "./gameboardv1.css";
import GetGameDataBackend from "./getGameDataBackend";
import {useParams} from "react-router";
import {UpdateShips} from "../forms/UpdateShips";
import {UpdateSalvo} from "../forms/UpdateSalvo";

export const GameBoardV2=()=>{

    var { gameid } = useParams();
    const {databackend,isError,isLoading}=GetGameDataBackend(gameid);


    const translateBackendToFrontShips=(data)=>{
        const checkStatusShip=(shipLocations)=>{
            let cellStatus="02";
            var statusLocations=shipLocations.map(location=>cellStatus==location.slice(-2));
            //console.log(statusLocations);
            let countCellHits=statusLocations.reduce(function(a,b){
                return b? ++a:a;
            },0)

            return Math.round(countCellHits/statusLocations.length*100);
        }
        const translateBackendToFront=(ship)=>{

            const checkOrientationShip=(shipLocations)=>{
                const orientationVertical=shipLocations.every(location=>{
                    if(location.substring(0,2)===shipLocations[0].substring(0,2))
                        return true;})
                const orientationHorizontal=shipLocations.every(
                    location=>{
                    if(location.substring(2,4)===shipLocations[0].substring(2,4))
                        return true;}
                )
                const orientationPoint=shipLocations.every(
                    location=>{
                        if(location.substring(0,2)===shipLocations[0].substring(0,2) && location.substring(2,4)===shipLocations[0].substring(2,4))
                            return true
                    }
                )
                if (orientationVertical) return 'vertical';
                else if (orientationHorizontal) return 'horizontal'
                else if (orientationPoint) return 'point'

            }

            let shipId=ship.shipName;
            let shipLocations=ship.locations;
            let x=parseInt(shipLocations[0].substring(0,2));
            let y=parseInt(shipLocations[0].substring(2,4));
            let w=0;
            let h=0;
            let shipLength=shipLocations.length;
            let statusChips=checkStatusShip(shipLocations);
            switch (checkOrientationShip(shipLocations)){

                case 'horizontal':
                    w=parseInt(shipLength);
                    h=1;
                    break
                case 'vertical':
                    w=1;
                    h=parseInt(shipLength);
                    break
                case 'point':
                    w=1;
                    h=1;
                    break;
                default:
                    w=1;
                    h=1;
            }
            let lowerLimit=0;
            let almostLimit=99;
            let hitLimit=100;
            let formatShipStatus=`<div class='text-white bg-success'>${shipId}-${statusChips}%<div/>`;
            if(statusChips===lowerLimit){
                formatShipStatus=`<div class='text-white bg-success'>${shipId}-${statusChips}%<div/>`;
            } else if (statusChips>lowerLimit && statusChips<=99) {
                formatShipStatus=`<div class='text-white bg-warning'>${shipId}-${statusChips}%<div/>`;
            } else if (statusChips===100){
                formatShipStatus=`<div class='text-white bg-danger'>${shipId}-${statusChips}%<div/>`;
            };



            let frontEndLocation={id:shipId,x: x, y: y, w: w,h: h,autoPosition:false,content: formatShipStatus}
            return frontEndLocation;
        }

        //console.log(data[0])
        //let game=data[0].game;
        //let gameId=data[0].game.id;
        //let salvoesBackend=data[0].salvoes;
        let dataBackendTransformedFrontend=[];
        data[0].ships.map((ship)=>dataBackendTransformedFrontend.push(translateBackendToFront(ship)));
        //console.log(game,gameId,salvoesBackend,shipsBackend)
        return dataBackendTransformedFrontend;
    }
    let serializedShipsData=translateBackendToFrontShips(databackend);

    const translateBackendToFrontSalvoes=(data)=>{

        const translateBackendToFront=(salvo)=>{

            const checkOrientationShip=(salvoLocations)=>{
                const orientationVertical=salvoLocations.every(location=>{

                    if(location.substring(0,2)===salvoLocations[0].substring(0,2))
                        return true;})
                const orientationHorizontal=salvoLocations.every(
                    location=>{

                        if(location.substring(2,4)===salvoLocations[0].substring(2,4))
                            return true;}
                )
                const orientationPoint=salvoLocations.every(
                    location=>{
                        if(location.substring(0,2)===salvoLocations[0].substring(0,2) && location.substring(2,4)===salvoLocations[0].substring(2,4))
                            return true
                    }
                )
                if (orientationVertical) return 'vertical';
                else if (orientationHorizontal) return 'horizontal'
                else if (orientationPoint) return 'point'

            }

            let salvoId=salvo.salvoId;
            let salvoLocations=salvo.locations;
            let x=parseInt(salvoLocations[0].substring(0,2));
            let y=parseInt(salvoLocations[0].substring(2,4));
            let status="0"+salvoLocations[0].substring(5,7);
            //console.log(salvoLocations[0],status)
            let w=0;
            let h=0;
            let salvoLength=salvoLocations.length;
            switch (checkOrientationShip(salvoLocations)){
                case 'horizontal':
                    w=parseInt(salvoLength);
                    h=1;
                    break
                case 'vertical':
                    w=1;

                    h=parseInt(salvoLength);
                    break
                case 'point':
                    w=1;
                    h=1;
                    break;
                default:
                    w=1;
                    h=1;
            }
            let formatSalvoDefault;
            let formatSalvoStatus01=`<p class='text-white bg-success'>${salvoId}-${status}<p/>`;
            let formatSalvoStatus02=`<p class='text-white bg-warning'>${salvoId}-${status}<p/>`;
            let formatSalvoStatus03=`<p class='text-white bg-danger'>${salvoId}-${status}<p/>`;

            switch (status){
                case "01":
                    formatSalvoDefault=formatSalvoStatus01;
                    break;
                case "02":
                    formatSalvoDefault=formatSalvoStatus02;
                    break;
                case "03":
                    formatSalvoDefault=formatSalvoStatus03;
                    break;
                default:
                    formatSalvoDefault=formatSalvoStatus01;
            }
            let frontEndLocation={id:salvoId,x: x, y: y, w: w,h: h,noMove:true,autoPosition:false,content:formatSalvoDefault}
            return frontEndLocation;
        }

        //console.log(data[0])
        //let game=data[0].game;

        //let gameId=data[0].game.id;
        //let salvoesBackend=data[0].salvoes;
        let dataBackendTransformedFrontend=[];
        data[0].salvoes.map((salvo)=>dataBackendTransformedFrontend.push(translateBackendToFront(salvo)));
        //console.log(game,gameId,salvoesBackend,shipsBackend)
        return dataBackendTransformedFrontend;
    }
    let serializedSalvoesData=translateBackendToFrontSalvoes(databackend);
    //console.log(serializedSalvoesData);
    var gridOptionsShips = {column: 10,disableResize:true,maxRow:10,row:10,float:true};
    var gridOptionsSalvos = {column: 10,disableResize:true,maxRow:11,row:10,float:true};

    const flipElement=(elementToUpdate,grid)=>{
        // this FlipElement need to improved because when an element is flipped and the element is horizontal  and try to convert vertical
        // to the size didn't return to the original size for now is a bug to fix the mechanical to Flipping need more logical to be aware
        let elementToUpdateW=elementToUpdate.gridstackNode.w;
        let elementToUpdateH=elementToUpdate.gridstackNode.h;
        //let elementToUpdateId=""+elementToUpdate.id

        grid.update(elementToUpdate,{x:elementToUpdate.gridstackNode.x, y: elementToUpdate.gridstackNode.y, w: elementToUpdateH,h: elementToUpdateW,autoPosition:false,content: elementToUpdate.content})
    }


    const dblClickSalvos=(elementToUpdate)=>{
        if(databackend[0].onPlayingTurn){
            let slavoPosition="0"+elementToUpdate.gridstackNode.x+"0"+elementToUpdate.gridstackNode.y;
            //This regular expression is used to extract the display text "0702-01" part of this HTML
            // <div class='text-white bg-success'>0702-01<div/> and then extract the status part "01"
            const regExtractLocation = new RegExp(/(?<=>)(.*\n?)(?=<)/);
            let salvoStatus="0"+elementToUpdate.gridstackNode.content.match(regExtractLocation)[0].substring(6,8);
            //console.log("salvoPosition ",slavoPosition,"salvoStatus ",salvoStatus,"gameid ",gameid)
        let salvoFired="02";
            switch (salvoStatus){
                case "01":
                    let dataSalvo={
                        salvoPosition:slavoPosition,
                        salvoStatus:salvoFired
                    }
                    UpdateSalvo(dataSalvo,gameid);
                    break;
                case "02":
                    console.log("Salvo has been fired didn't hit")
                    break
                case "03":
                    console.log("Salvo has been fired and hit")
                    break
            default:
                    console.log("No status set in the Salvo")
        }

        }
    }
    useEffect(() => {
        const cellHeight=38;
        const cellWidth=38;
        let grid01 = GridStack.init(gridOptionsShips,document.getElementById('grid1'));
        grid01.removeAll()
        grid01.load(serializedShipsData)
        grid01.cellHeight(cellHeight)
        grid01.cellWidth(cellWidth)
        let grid01Elements=grid01.getGridItems();
        grid01Elements.map((gridItem)=>(gridItem.ondblclick=(()=>flipElement(gridItem,grid01))));

        let grid02 = GridStack.init(gridOptionsSalvos,document.getElementById('grid2'));
        grid02.removeAll()
        grid02.cellHeight(cellHeight)
        grid02.cellWidth(cellWidth);
        grid02.load(serializedSalvoesData)
        let grid02Elements=grid02.getGridItems();
        grid02Elements.map((gridItem)=>(gridItem.ondblclick=(()=>dblClickSalvos(gridItem))))

    });


    function addWidget(){
        var grid=document.getElementById('grid1').gridstack;

        grid.addWidget({id:"item06",x: 0, y: 0,w:1,h: 1,content: 'item06'});
        //grid.addWidget({id:"item07",x: 0, y: 5,w:1,h: 1,content: 'item07'});

    }
    function getGrid(){
        let grid=document.getElementById('grid1').gridstack
        let gridItems=grid.getGridItems() // This give the array of the GrisStackElements I need to do a
        // map of this adding the double function about how response to the ondblclick function
        // grid.update to update the gridStackElement
        let gridShips=[]
        gridItems.map((item)=>(gridShips.push(item.gridstackNode)))
        console.log(gridShips)

    }
    const translateFrontEndToBackendShip=(element)=>{
        // "050202" this the coordinates of the backend of one cell of one ship
        // this function translate the coordinates of the one ship and return all the locations of ship on the BackEnd
        let statusShip='01'
        const getShipLength=(w,h)=>{
            let lengthShip=0;
            if(w===1){lengthShip=h}
            else if(h===1) {lengthShip=w}
            return lengthShip
        }
        const getShipOrientation=(w,h)=>{
            if(w>h) return 'horizontal'
            else if(h>w) return 'vertical'
            else if(h===w) return 'point'
        }
        let shipLength=getShipLength(element.w,element.h);
        let shipOrientation=getShipOrientation(element.w,element.h)
        let shipTransformedBackEndCoordinates=[]
         for (let i=0;i<shipLength;i++){
                switch (shipOrientation){
                    case 'horizontal':
                        let xElementToIncrement=element.x+i;
                        let shipBackEndLocationH='0'+xElementToIncrement+'0'+element.y+statusShip;
                        shipTransformedBackEndCoordinates.push(shipBackEndLocationH)
                        break
                    case 'vertical':
                        let yElementToIncrement=element.y+i;
                        let shipBackEndLocationV='0'+element.x+'0'+yElementToIncrement+statusShip;
                        shipTransformedBackEndCoordinates.push(shipBackEndLocationV)
                        break
                    case 'point':
                        let shipBackEndLocationP='0'+element.x+'0'+element.y+statusShip;
                        shipTransformedBackEndCoordinates.push(shipBackEndLocationP)
                        break
                    default:
                        let shipBackEndLocationD='0'+element.x+'0'+element.y+statusShip;
                        shipTransformedBackEndCoordinates.push(shipBackEndLocationD)

                }

         }
        return shipTransformedBackEndCoordinates
    }
    function transformShipsCoordinatesToBackend(){
        let grid=document.getElementById('grid1').gridstack
        let gridItems=grid.getGridItems()
        let arrayElementShips=[]
        gridItems.map((item)=>(arrayElementShips.push(item.gridstackNode)))
        let arrayShipsBackEndCoordinates=[]
        arrayElementShips.map((element)=>{
                let shipBackend={'shipName':element.id,'locations':[]};
                shipBackend['locations'].push(translateFrontEndToBackendShip(element))
                arrayShipsBackEndCoordinates.push(shipBackend)
        }
        )
        return arrayShipsBackEndCoordinates
    }

    const saveShipsBackend=(gameid)=>{
        let data=transformShipsCoordinatesToBackend();
        //console.log({...data});
        // {...data} is for transform the array in an object because the end point is expecting an object
        UpdateShips({...data},gameid)
    }



    const updateElement=()=>{
        let grid=document.getElementById('grid1').gridstack;
        let gridElements=grid.getGridItems();
        //console.log(gridItems[0].ondblclick=(()=>(console.log("ondlbclick"))))
        //gridItems[0].ondblclick=(()=>(console.log("ondlbclick")))
        let elementToUpdate=gridElements[0];
        elementToUpdate.ondblclick=(()=>flipElement(elementToUpdate,grid))
        //console.log(grid.getGridItems())
    }
    const stopDragDrop=()=>{
        let grid=document.getElementById('grid1').gridstack;
        let itemOptions= {noMove:true,noResize:true,locked:true}
        let gridElements=grid.getGridItems();
        gridElements.map((element)=>(grid.update(element,itemOptions)))
    }
    const changeContent=()=>{
        let grid=document.getElementById('grid1').gridstack;
        let gridElements=grid.getGridItems();
        let elementToUpdate=gridElements[0];

        //elementToUpdate.gridstackNode.id="1/5"
        grid.update(elementToUpdate,{content: 'ship00 1/5'});
    }
console.log(databackend[0].onPlayingTurn)
    return (
        <div >
            {<button onClick={()=>addWidget()}>add Items "grid-stack"</button>}
            {<button onClick={()=>getGrid()}>Get the Grid "grid-stack"</button>}
           {/* {<button onClick={()=>updateElement()}>Update element</button>}*/}
            {<button onClick={()=>stopDragDrop()}>Stop Drag and Drop</button>}
            {<button onClick={()=>changeContent()}>Change content</button>}
            {<button onClick={()=>saveShipsBackend(gameid)}>Update the positions ships Backend</button>}
            <p>Game:{databackend[0].game.gameName} BoardStatus {databackend[0].gamePlayerStatus}</p>
            <p>Players: {databackend[0].player.email} vs {databackend[1].player.email}</p>
            <p>onPlayingTurn {databackend[0].onPlayingTurn+''}</p>
            <p>Ships</p>
            <div className="grid-stack border border-primary" id="grid1"></div>
            <p>Salvos</p>
            <div className="grid-stack border border-primary" id="grid2"></div>

        </div>

    );};