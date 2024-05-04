import { AcGameObject } from "./AcGameObject";
import { Cell } from "./Cell";

export class Snake extends AcGameObject {
    constructor(info,gamemap) {
        super()

        this.id = info.id
        this.color = info.color
        this.gamemap = gamemap

        this.cells = [ new Cell(info.r, info.c) ]
        this.next_cell = null

        this.speed = 5
        this.direction = -1  
        this.status = 'idle'

        this.dr = [-1,0,1,0]
        this.dc = [0,1,0,-1]

        this.step = 0
        this.eps = 1e-2
    }

    start() {

    }

    set_direction(d) {
        this.direction = d
    }

    next_step() {
        const d = this.direction
        this.next_cell = new Cell(this.cells[0].r + this.dr[d], this.cells[0] + this.dc[d])
        this.direction = -1
        this.status = 'move'
        this.step++

        const k = this.cells.length
        for(let i = k; i > 0; i--) {
            this.cells[i] = JSON.parse(JSON.stringify(this.cells[i - 1]))
        }
    }

    update_move() {
        const dx = this.next_cell.x - this.cells[0].x
        const dy = this.next_cell.y - this.cells[0].y
        const distance = Math.sqrt(dx * dx + dy * dy)
        
        if(distance < this.eps) {
            this.cell[0] = this.next_cell
            this.next_cell = null
            this.status ='idle'
        }else {
            const move_distence = this.speed * this.timedelta / 1000
            this.cells[0].x += move_distence * dx / distance
            this.cells[0].y += move_distence * dy / distance
        }

    }

    update() {
        if(this.status === 'move') {
            this.update_move()
        }
        this.render()

    }

    render() {
        const L = this.gamemap.L
        const ctx  = this.gamemap.ctx

        ctx.fillStyle = this.color
        for(const cell of this.cells) {
            ctx.beginPath()
            ctx.arc(cell.x * L, cell.y * L, L / 2, 0, Math.PI * 2)
            ctx.fill()
        }
    }
}