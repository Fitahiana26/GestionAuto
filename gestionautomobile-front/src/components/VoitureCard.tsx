import type { Voitures } from "../types/Voitures";

interface Props {
    voiture: Voitures;
}

function VoitureCard({ voiture }: Props) {
    return (
        <div className="voiture-card">
            <h2>Voiture ID: {voiture.idVoiture}</h2>
            <p>Prix: {voiture.prixAchat.toLocaleString("fr-FR")}</p>
            <p>Date d'ajout: {voiture.dateAjoute}</p>
            <p>Description: {voiture.description}</p>
        </div>
    );
}

export default VoitureCard;