import axios from "axios";
import type { Voitures } from "../types/Voitures";

const API_BASE_URL = "/api";

export const getVoitures = async (): Promise<Voitures[]> => {
    const response = await axios.get(`${API_BASE_URL}/voitures`);
    return response.data;
};

export const getVoitureById = async (id: string): Promise<Voitures> => {
    const response = await axios.get(`${API_BASE_URL}/voitures/${id}`);
    return response.data;
};

export const createVoiture = async (voiture: Omit<Voitures, "idVoiture">): Promise<Voitures> => {
    const response = await axios.post(`${API_BASE_URL}/voitures`, voiture);
    return response.data;
};

export const updateVoiture = async (id: string, voiture: Partial<Voitures>): Promise<Voitures> => {
    const response = await axios.put(`${API_BASE_URL}/voitures/${id}`, voiture);
    return response.data;
};

export const deleteVoiture = async (id: string): Promise<void> => {
    await axios.delete(`${API_BASE_URL}/voitures/${id}`);
};
