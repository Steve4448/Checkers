# Two Player Checkers Server & Client
This was just a learning project to make checkers on a server and client with (hopefully) proper checkers game logic.
![Image of the checkers board](Check%20Errs.png)

# How to use
First start the server by running `java main.net.CheckersServer`

Then, the client by running `java main.CheckersGUI`

In order to customize the port/IP that is being used, or for further customization, please read either the **Configuring the Server** and the **Configuring the Client** sections below.

## Configuring the Server
By default the port that will be used is 8183, in order to change this, use:

- `-port NUMBER` eg `-port 8184` to use port 8184 instead.

You can also change the board size which by default is a 8x8, in order to change this, use:

- `-boardSize NUMBER` eg `-boardSize 10` will make a 10x10 board instead.

As a full example on how to run the server with the above examples:

`java main.net.CheckersServer -port 8184 -boardSize 10`

## Configuring the Client
By default the port that will be used is 8183, in order to change this, use:

- `-port NUMBER` eg `-port 8184` to use port 8184 instead.

By default the IP that will be used is 127.0.0.1, in order to change this, use:

- `-ip STRING` eg `-ip "192.168.0.100"` to use 192.168.0.100 as the IP instead.

As a full example on how to run the client with the above examples:

`java main.CheckersGUI -port 8184 -ip "192.168.0.100"`

## Todo List
- The game isn't aware of pieces that are trapped and therefor draw games aren't calculated.
- Add the option of playing without the rule of forced jumps.
- A turn indicator.
- Add the option of deciding the game board size without the command line. Possibly a main menu?
- Possibly show a grid indicating the tile's index with a log of what piece moved where.
- Animations for moving pieces?
