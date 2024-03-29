import React, {useEffect} from "react";
import {GridStack} from "gridstack";
import 'gridstack/dist/gridstack.css';
import 'gridstack/dist/h5/gridstack-dd-native';
import "./gameboardv1.css";
export const GameBoardV1=()=>{
    let serializedData = [
        {id:"ship00",x: 0, y: 0, w: 5,h: 1,autoPosition:false,content: 'ship00 0/5'},
        {id:"ship01",x: 1, y: 2, w: 1,h: 3,autoPosition:false,content: 'ship01 0/3'},
        {id:"ship02",x: 2, y: 3, w: 1,h: 4,autoPosition:false,content: 'ship02 0/4'},
        {id:"ship03",x: 3, y: 4, w: 2,h: 1,autoPosition:false,content: 'ship03 0/2'},
        {id:"ship04",x: 4, y: 5, w: 2,h: 1,autoPosition:false,content: 'ship04 0/2'}
    ];

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

    const createElementsSalvos=()=>{
        let elementsSalvos=[];
        for(let x=0;x<=9;x++){
            for(let y=0;y<=9;y++){
                let salvoId=""+x+y;
                elementsSalvos.push({id:salvoId,x: x, y: y, w: 1,h: 1,autoPosition:false,content: salvoId,noMove:true})
            }
        }
        return elementsSalvos;
    }
    const dblClickSalvos=(elementToUpdate,grid)=>{
        console.log(elementToUpdate.gridstackNode.x,elementToUpdate.gridstackNode.y)

    }
    useEffect(() => {
        const cellHeight=38;
        const cellWidth=38;
        let grid01 = GridStack.init(gridOptionsShips,document.getElementById('grid1'));
        grid01.removeAll()
        grid01.load(serializedData)
        grid01.cellHeight(cellHeight)
        grid01.cellWidth(cellWidth)
        let grid01Elements=grid01.getGridItems();
        grid01Elements.map((gridItem)=>(gridItem.ondblclick=(()=>flipElement(gridItem,grid01))));
        let grid02 = GridStack.init(gridOptionsSalvos,document.getElementById('grid2'));
        grid02.removeAll()
        grid02.cellHeight(cellHeight)
        grid02.cellWidth(cellWidth);
        grid02.load(createElementsSalvos())
        let grid02Elements=grid02.getGridItems();
        grid02Elements.map((gridItem)=>(gridItem.ondblclick=(()=>dblClickSalvos(gridItem,grid02))))
        //console.log("use Effect ran")
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
                        let shipBackEndLocationP=''+element.x+'0'+element.y+statusShip;
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
    const saveShipsBackend=()=>{
        console.log(transformShipsCoordinatesToBackend())
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


    return (
        <div >
            {<button onClick={()=>addWidget()}>add Items "grid-stack"</button>}
            {<button onClick={()=>getGrid()}>Get the Grid "grid-stack"</button>}
           {/* {<button onClick={()=>updateElement()}>Update element</button>}*/}
            {<button onClick={()=>stopDragDrop()}>Stop Drag and Drop</button>}
            {<button onClick={()=>changeContent()}>Change content</button>}
            {<button onClick={()=>saveShipsBackend()}>Save the ships into Backend</button>}
            <p>Ships</p>
            <div className="grid-stack border border-primary" id="grid1"></div>
            <p>Salvos</p>
            <div className="grid-stack border border-primary" id="grid2"></div>

        </div>

    );};