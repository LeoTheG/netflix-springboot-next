"use client";
import { useEffect, useState } from "react";
import NetflixLogo from "@/assets/netflix_logo.png";
import { InfoIcon, PlayIcon } from "lucide-react";

interface IMediaItem {
  id: number;
  title: string;
  description: string;
  releaseDate: string;
  genre: string;
  type: string;
  imageUrls: string[];
  previewImageUrl: string;
  titleLogoUrl: string;
}

export const Home = () => {
  const [mediaItems, setMediaItems] = useState<IMediaItem[]>([]);

  useEffect(() => {
    requestMediaItems().then((response) => {
      response.json().then((data) => {
        setMediaItems(data);
      });
    });
  }, []);

  console.log({ mediaItems });

  return (
    <div className="[&_*]:font-sans ">
      <Header />
      {mediaItems.length > 0 && (
        <div className="absolute w-full top-0">
          <Banner
            img={mediaItems[0].previewImageUrl}
            titleLogo={mediaItems[0].titleLogoUrl}
            description={mediaItems[0].description}
          />
          <MediaList mediaItems={mediaItems} title="Trending Now" />
        </div>
      )}
    </div>
  );
};

const Banner = ({
  img,
  titleLogo,
  description
}: {
  img: string;
  titleLogo: string;
  description: string;
}) => {
  return (
    <>
      <img
        src={img}
        alt="Banner"
        className="h-auto max-h-[600px] w-full object-cover object-top"
      />
      <div className="absolute bottom-[35%] px-16">
        <img src={titleLogo} />
        <div className="w-[400px] text-white">{description}</div>
        <div className="flex gap-4">
          <button className="bg-white w-fit text-black px-4 py-2 rounded-md mt-4 font-semibold flex">
            <PlayIcon />
            <span>Play</span>
          </button>
          <button className="flex w-fit bg-gray-700 text-white px-4 py-2 rounded-md mt-4 font-semibold gap-2">
            <InfoIcon />
            <span>More Info</span>
          </button>
        </div>
      </div>
    </>
  );
};

const MediaList = ({
  mediaItems,
  title
}: {
  mediaItems: IMediaItem[];
  title: string;
}) => {
  return (
    <div className="flex flex-col z-50 relative px-16 mt-[-35px]">
      <div className="text-white font-semibold">{title}</div>
      <div className="flex overflow-x-auto gap-1">
        {mediaItems.map((mediaItem) => (
          <div key={mediaItem.id} className="flex-shrink-0">
            <img
              src={mediaItem.imageUrls[0]}
              alt={mediaItem.title}
              className="h-[125px] w-[220px] object-cover"
            />
          </div>
        ))}
      </div>
    </div>
  );
};

const headerItems = [
  "Home",
  "TV Shows",
  "Movies",
  "New & Popular",
  "My List",
  "Browse By Languages"
];
const Header = () => {
  return (
    <div
      className="flex gap-4 px-16 py-8 sticky top-0 min-h-[70px] z-50 [&_*]:text-white"
      style={{
        backgroundImage:
          "linear-gradient(180deg,rgba(0,0,0,.7) 10%,transparent)"
      }}
    >
      <div className="mr-8">
        <img src={NetflixLogo.src} alt="Netflix Logo" className="w-24" />
      </div>

      <div className="flex gap-4">
        {headerItems.map((item, index) => (
          <div key={index} className={item === "Home" ? "font-semibold" : ""}>
            {item}
          </div>
        ))}
      </div>
    </div>
  );
};

/* Example response
{
    "id": 1,
    "title": "Gilmore Girls",
    "description": "Fiercely independent single mom Lorelai raises gifted, Ivy League-bound daughter Rory amid a continual stream of quick-witted repartee.",
    "releaseDate": "2023-09-28T21:43:18.527+00:00",
    "genre": "Drama",
    "type": "TV Show",
    "imageUrls": [
        "/images/gilmore-girls-1.png",
        "/images/gilmore-girls-2.png"
    ],
    "previewImageUrl": "/images/gilmore-girls.gif"
}
*/
const requestMediaItems = () => fetch(`${SERVER_URL}/mediaitems`);
const SERVER_URL =
  process.env.NODE_ENV === "development"
    ? "http://localhost:8080"
    : "https://leog-netflix-backend.fly.dev";
