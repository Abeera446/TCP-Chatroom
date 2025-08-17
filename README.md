# TCP Chatroom

A simple multithreaded TCP chatroom built with Java sockets.  
Includes a server that handles multiple clients concurrently.
Includes both server and client inside one package, launched via `Main.java`.

## Features
- Multiple clients via threads (one handler per client)
- One entry point (`Main.java`) → choose **Server** or **Client** at runtime
- Names on connect
- Graceful 'quit' to leave
- Server logs join/leave events
- Minimal, readable code for learning sockets + threading

## Build & Run
1) Compile
2) Start the Server (port number can be any number between 0 and 65535)
3) Start Client(s) (in separate terminals)
4) When prompted, enter your name and start chatting. Enter 'quit' to leave.

## Example
Server: Server started! Waiting for clients to connect...
Server: Mark has joined the chat!
Server: Felix has joined the chat!
Felix: Hi.
Mark: Hello.
Server: Mark has left the chat!
