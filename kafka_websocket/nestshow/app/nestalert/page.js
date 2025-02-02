"use client";

import { useEffect, useState } from "react";
import { Client } from "@stomp/stompjs";
import SockJS from "sockjs-client";

export default function SensorAlertsPage() {
    const [alerts, setAlerts] = useState([]);
    const [connectionStatus, setConnectionStatus] = useState("Disconnected");

    useEffect(() => {
        const socket = new SockJS("http://localhost:8080/ws");
        const stompClient = new Client({
            webSocketFactory: () => socket,
            debug: (str) => console.log(str),
            onConnect: () => {
                console.log("Connected to WebSocket");
                setConnectionStatus("Connected");
                stompClient.subscribe("/topic/alerts", (message) => {
                    console.log("Raw message received:", message.body);
                    setAlerts((prev) => [message.body, ...prev]);
                });
            },
            onStompError: (frame) => {
                console.error("STOMP error:", frame.headers["message"]);
                setConnectionStatus("Error");
            },
        });

        stompClient.activate();

        return () => {
            stompClient.deactivate();
        };
    }, []);

    return (
        <div className="container mx-auto p-6">
            <h1 className="text-3xl font-bold mb-4">SmartHome Sensor Alerts</h1>
            <p className={`mb-4 ${connectionStatus === "Connected" ? "text-green-600" : "text-red-600"}`}>
                Connection Status: {connectionStatus}
            </p>

            <div className="flex flex-col">
                {alerts.length > 0 ? (
                    alerts.map((alert, index) => (
                        <div
                            key={index}
                            className="bg-orange-100 border-l-4 border-orange-500 text-orange-700 p-4 mb-4 last:mb-0"
                            role="alert"
                        >
                            <p>{alert}</p>
                        </div>
                    ))
                ) : (
                    <div className="text-center text-gray-500">
                        <p>No alerts yet.</p>
                    </div>
                )}
            </div>
        </div>
    );
}
