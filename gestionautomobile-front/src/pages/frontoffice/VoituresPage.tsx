import { useVoitures } from "../../hooks/useVoitures";
import VoitureCard from "../../components/VoitureCard";
 
function VoituresPage() {
    const { voitures, loading, error } = useVoitures();

    return (
        <div>
            <h1>Liste des voitures</h1>
            {loading && <p>Chargement des voitures...</p>}
            {error && <p role="alert">Impossible de charger les voitures : {error}</p>}
            {!loading && !error && voitures.length === 0 && (
                <p>Aucune voiture trouvée.</p>
            )}
            {!loading &&
                !error &&
                voitures.map((voiture) => (
                    <VoitureCard key={voiture.idVoiture} voiture={voiture} />
                ))}
        </div>
    );
}

export default VoituresPage;